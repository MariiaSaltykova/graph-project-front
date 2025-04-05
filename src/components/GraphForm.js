import React, { useState } from 'react';
import './GraphForm.css';

const GraphForm = () => {
  const [isWeighted, setIsWeighted] = useState(false);
  const [isDirected, setIsDirected] = useState(false);
  const [vertices, setVertices] = useState('');
  const [edges, setEdges] = useState('');
  const [minWeight, setMinWeight] = useState('');
  const [maxWeight, setMaxWeight] = useState('');
  const [weightType, setWeightType] = useState('int');
  const [endpoint, setEndpoint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    // Prosta walidacja
    if (!vertices || parseInt(vertices) <= 0) {
      alert("Liczba wierzchołków musi być większa od 0.");
      return;
    }
    if (!edges || parseInt(edges) < parseInt(vertices) - 1) {
      alert("Liczba krawędzi musi być co najmniej liczba wierzchołków - 1.");
      return;
    }
    if (isWeighted) {
      if (minWeight === '' || maxWeight === '') {
        alert("Podaj minimalną i maksymalną wagę.");
        return;
      }
      if (parseFloat(minWeight) > parseFloat(maxWeight)) {
        alert("Minimalna waga nie może być większa od maksymalnej.");
        return;
      }
    }

    // Przygotowanie danych do wysłania
    const graphData = {
      weighted: isWeighted,
      directed: isDirected,
      vertices: parseInt(vertices),
      edges: parseInt(edges),
      minWeight: isWeighted ? parseFloat(minWeight) : null,
      maxWeight: isWeighted ? parseFloat(maxWeight) : null,
      weightType: isWeighted ? weightType : null,
      endpoint: endpoint
    };

    console.log("Dane grafu: ", graphData);

    // Wysyłanie danych do backendu (endpoint /api/generateGraph)
    fetch('/api/generateGraph', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(graphData)
    })
      .then(response => response.json())
      .then(data => {
        console.log('Sukces:', data);
        // Możesz tutaj dodać obsługę odpowiedzi i aktualizację interfejsu
      })
      .catch(error => console.error('Błąd:', error));
  };

  return (
    <div className="form-container">
      <h2>Generowanie Grafu</h2>
      <form onSubmit={handleSubmit} className="graph-form">
        <div className="form-group">
          <label>
            <input 
              type="checkbox"
              checked={isWeighted}
              onChange={(e) => setIsWeighted(e.target.checked)}
            />
            Ważony
          </label>
        </div>
        <div className="form-group">
          <label>
            <input 
              type="checkbox"
              checked={isDirected}
              onChange={(e) => setIsDirected(e.target.checked)}
            />
            Skierowany
          </label>
        </div>
        <div className="form-group">
          <label>Liczba wierzchołków:</label>
          <input 
            type="number"
            value={vertices}
            onChange={(e) => setVertices(e.target.value)}
            placeholder="Np. 5"
          />
        </div>
        <div className="form-group">
          <label>Liczba krawędzi:</label>
          <input 
            type="number"
            value={edges}
            onChange={(e) => setEdges(e.target.value)}
            placeholder={`Co najmniej ${vertices ? vertices - 1 : 0}`}
          />
        </div>
        {isWeighted && (
          <>
            <div className="form-group">
              <label>Minimalna waga:</label>
              <input 
                type="number"
                value={minWeight}
                onChange={(e) => setMinWeight(e.target.value)}
                placeholder="Np. 1"
              />
            </div>
            <div className="form-group">
              <label>Maksymalna waga:</label>
              <input 
                type="number"
                value={maxWeight}
                onChange={(e) => setMaxWeight(e.target.value)}
                placeholder="Np. 10"
              />
            </div>
            <div className="form-group">
              <label>Typ wagi:</label>
              <select value={weightType} onChange={(e) => setWeightType(e.target.value)}>
                <option value="int">Int</option>
                <option value="float">Float</option>
              </select>
            </div>
          </>
        )}
        <div className="form-group">
          <label>Endpoint (Cel):</label>
          <input 
            type="number"
            value={endpoint}
            onChange={(e) => setEndpoint(e.target.value)}
            placeholder="Numer wierzcholka"
          />
        </div>
        <button type="submit" className="submit-button">Generuj Graf</button>
      </form>
    </div>
  );
};

export default GraphForm;
