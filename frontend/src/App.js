import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import './App.css';

import Login from './components/Login/Login';
import Dashboard from './components/Dashboard/Dashboard';
import FileExplorer from './components/FileExplorer/FileExplorer';
import Admin from './components/Admin/Admin';
import Settings from './components/Settings/Settings';

function App() {
  return (
    <Router>
      <div className="App">
        <nav>
          <ul>
            <li><Link to="/">Dashboard</Link></li>
            <li><Link to="/login">Login</Link></li>
            <li><Link to="/explorer">File Explorer</Link></li>
            <li><Link to="/admin">Admin</Link></li>
            <li><Link to="/settings">Settings</Link></li>
          </ul>
        </nav>

        <hr />

        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/login" element={<Login />} />
          <Route path="/explorer" element={<FileExplorer />} />
          <Route path="/admin" element={<Admin />} />
          <Route path="/settings" element={<Settings />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
