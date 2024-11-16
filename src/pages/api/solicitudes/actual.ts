"use client";

import Card from "@/components/Card";

const Actual = () => {
  return (
    <div className="space-y-4">
      <h1 className="text-2xl font-bold text-gray-800">Tipo de Cambio Actual</h1>
      <Card>
        <p className="text-lg">
          El tipo de cambio actual es: <strong>7.85</strong>
        </p>
      </Card>
    </div>
  );
};

export default Actual;
