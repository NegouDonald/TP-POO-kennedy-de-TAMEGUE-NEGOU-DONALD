 
import React, { useState } from "react";
function Recherche() {
  const [serial, setSerial] = useState("");
  const [result, setResult] = useState(null);

  const handleSearch = async () => {
    const res = await fetch(`http://localhost:8080/vol?serial=${serial}`);
    const data = await res.json();
    setResult(data);
  };

  return (
    <div className="p-4">
      <input
        placeholder="Numéro de série"
        value={serial}
        onChange={(e) => setSerial(e.target.value)}
        className="border p-2"
      />
      <button onClick={handleSearch} className="bg-blue-500 text-white p-2 ml-2">
        Rechercher
      </button>
      {result && (
        <div className="mt-4">
          {typeof result === "string" ? result : (
            <>
              <p><strong>Type :</strong> {result.type}</p>
              <p><strong>Description :</strong> {result.description}</p>
              <p><strong>Contact :</strong> {result.ownerContact}</p>
            </>
          )}
        </div>
      )}
    </div>
  );
}

export default Recherche;
