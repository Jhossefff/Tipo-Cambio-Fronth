const Card = ({ children }: { children: React.ReactNode }) => {
    return (
      <div className="p-4 bg-white rounded-lg shadow-md border border-gray-200">
        {children}
      </div>
    );
  };
  
  export default Card;
  