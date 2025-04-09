import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import  Recherche from "./pages/Recherche";


export default function App() {
  return (
    <Router>
      <div className="p-4">
        <h1 className="text-2xl font-bold mb-4">Système d'identification d'objets volés</h1>
        <nav className="mb-4 space-x-4">
          <Link to="/ss" className="text-blue-600">Accueil</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/aa" element={<Recherche />} />
        </Routes>
      </div>
    </Router>
  );
}