
// components/DeclareForm.jsx
import React, { useState } from "react";
import { declarerObjet } from "../services/api";

export default function DeclareForm() {
  const [form, setForm] = useState({
    id: "",
    type: "",
    marque: "",
    modele: "",
    vole: true,
    proprietaire_email: "",
  });

  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const res = await declarerObjet(form);
    setMessage(res.message || "Objet déclaré.");
  };

  return (
    <div className="p-4 border rounded-xl shadow">
      <h2 className="text-xl font-semibold mb-2">Déclarer un objet volé</h2>
      <form onSubmit={handleSubmit} className="space-y-2">
        <input name="id" onChange={handleChange} placeholder="ID" className="w-full p-2 border rounded" />
        <input name="type" onChange={handleChange} placeholder="Type" className="w-full p-2 border rounded" />
        <input name="marque" onChange={handleChange} placeholder="Marque" className="w-full p-2 border rounded" />
        <input name="modele" onChange={handleChange} placeholder="Modèle" className="w-full p-2 border rounded" />
        <input name="proprietaire_email" onChange={handleChange} placeholder="Email du propriétaire" className="w-full p-2 border rounded" />
        <button type="submit" className="bg-red-600 text-white px-4 py-2 rounded">Déclarer</button>
      </form>
      {message && <p className="mt-2 text-green-600">{message}</p>}
    </div>
  );
}
