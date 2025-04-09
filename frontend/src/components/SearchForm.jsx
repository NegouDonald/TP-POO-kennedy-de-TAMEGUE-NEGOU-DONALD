import React, { useState } from "react";
import { rechercherObjet } from "../services/api";

export default function SearchForm() {
  const [id, setId] = useState("");
  const [result, setResult] = useState(null);

  const handleSearch = async (e) => {
    e.preventDefault();
    const data = await rechercherObjet(id);
    setResult(data);
  };

  return (
    <div className="p-4 border rounded-xl shadow">
      <h2 className="text-xl font-semibold mb-2">Rechercher un objet</h2>
      <form onSubmit={handleSearch} className="space-y-2">
        <input
          type="text"
          value={id}
          onChange={(e) => setId(e.target.value)}
          placeholder="Identifiant de l'objet"
          className="w-full p-2 border rounded"
        />
        <button type="submit" className="bg-blue-600 text-white px-4 py-2 rounded">
          Rechercher
        </button>
      </form>
      {result && (
        <div className="mt-4">
          <p><strong>Type:</strong> {result.type}</p>
          <p><strong>Marque:</strong> {result.marque}</p>
          <p><strong>Modèle:</strong> {result.modele}</p>
          <p><strong>Volé ?</strong> {result.vole ? "Oui" : "Non"}</p>
        </div>
      )}
    </div>
  );
}