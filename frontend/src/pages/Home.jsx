import React from "react";
import SearchForm from "../components/SearchForm";
import DeclareForm from "../components/DeclareForm";

export default function Home() {
  return (
    <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
      <SearchForm />
      <DeclareForm />
    </div>
  );
}