import { NextApiRequest, NextApiResponse } from 'next';
import { PrismaClient } from '@prisma/client';

const prisma = new PrismaClient();

export default async function handler(req: NextApiRequest, res: NextApiResponse) {
  if (req.method === 'GET') {
    // Obtener todas las solicitudes de tipo de cambio
    try {
      const solicitudes = await prisma.solicitudCambio.findMany();
      res.status(200).json(solicitudes);
    } catch (error) {
      res.status(500).json({ error: 'Error al obtener las solicitudes' });
    }
  } else if (req.method === 'POST') {
    // Crear una nueva solicitud de tipo de cambio
    const { numeroSolicitud, respuestaTipoCambio } = req.body;

    // Validación de los datos enviados en el cuerpo de la solicitud
    if (!numeroSolicitud || !respuestaTipoCambio) {
      return res.status(400).json({ error: 'Faltan datos en la solicitud' });
    }

    try {
      // Crear un nuevo registro en la base de datos usando Prisma
      const nuevaSolicitud = await prisma.solicitudCambio.create({
        data: { numeroSolicitud, respuestaTipoCambio }
      });
      res.status(201).json(nuevaSolicitud);
    } catch (error) {
      res.status(500).json({ error: 'Error al registrar la solicitud' });
    }
  } else {
    // Método no permitido
    res.setHeader('Allow', ['GET', 'POST']);
    res.status(405).end(`Method ${req.method} Not Allowed`);
  }
}
