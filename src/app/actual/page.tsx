import Card from "@/components/Card";

const Actual = () => {
  return (
    <div className="p-6 bg-gray-100 min-h-screen">
      <h1 className="text-3xl font-bold text-gray-800 mb-6">Tipo de Cambio Actual</h1>
      <Card>
        <p className="text-lg">
          El tipo de cambio actual es: <strong>7.85</strong>
        </p>
      </Card>
    </div>
  );
};

export default Actual;
