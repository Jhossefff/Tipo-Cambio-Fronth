import Card from "@/components/Card";

const Historial = () => {
  const historial = [
    { fecha: "2024-11-01", tipoCambio: 7.85 },
    { fecha: "2024-11-02", tipoCambio: 7.86 },
  ];

  return (
    <div className="space-y-4 p-6 bg-gray-100 min-h-screen">
      <h1 className="text-2xl font-bold text-gray-800">Historial de Tipos de Cambio</h1>
      {historial.map((item, index) => (
        <Card key={index}>
          <p>
            {item.fecha}: <strong>{item.tipoCambio}</strong>
          </p>
        </Card>
      ))}
    </div>
  );
};

export default Historial;
