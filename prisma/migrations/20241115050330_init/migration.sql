-- CreateTable
CREATE TABLE "SolicitudCambio" (
    "id" SERIAL NOT NULL,
    "numeroSolicitud" TEXT NOT NULL,
    "respuestaTipoCambio" TEXT NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT "SolicitudCambio_pkey" PRIMARY KEY ("id")
);
