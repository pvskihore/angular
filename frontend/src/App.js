import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import authService from './services/auth.service';
import './App.css';

import Login from './components/Login/Login';
import Dashboard from './components/Dashboard/Dashboard';
import FileExplorer from './components/FileExplorer/FileExplorer';
import Admin from './components/Admin/Admin';
import Settings from './components/Settings/Settings';

function App() {
  const [currentUser, setCurrentUser] = useState(undefined);

  useEffect(() => {
    const user = authService.getCurrentUser();
    if (user) {
      setCurrentUser(user);
    }
  }, []);

  const logOut = () => {
    authService.logout();
    setCurrentUser(undefined);
  };

  return (
    <Router>
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to={"/"} className="navbar-brand">
            DocMgmt
          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/explorer"} className="nav-link">
                File Explorer
              </Link>
            </li>

            {currentUser && currentUser.role === 'ADMIN' && (
              <li className="nav-item">
                <Link to={"/admin"} className="nav-link">
                  Admin
                </Link>
              </li>
            )}
          </div>

          {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/settings"} className="nav-link">
                  Settings
                </Link>
              </li>
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={logOut}>
                  LogOut
                </a>
              </li>
            </div>
          ) : (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/login"} className="nav-link">
                  Login
                </Link>
              </li>
            </div>
          )}
        </nav>

        <div className="container mt-3">
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/login" element={<Login />} />
            <Route path="/explorer" element={<FileExplorer />} />
            <Route path="/admin" element={<Admin />} />
            <Route path="/settings" element={<Settings />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
