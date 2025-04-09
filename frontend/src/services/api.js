const BASE_URL = import.meta.env.VITE_API_URL || "http://localhost:8000/api";

export async function rechercherObjet(id) {
  const res = await fetch(`${BASE_URL}/rechercher?id=${id}`);
  return await res.json();
}

export async function declarerObjet(data) {
  const res = await fetch(`${BASE_URL}/declarer`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  return await res.json();
}
