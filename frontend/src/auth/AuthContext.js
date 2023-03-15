import React, { createContext, useState,useEffect } from 'react';
import { getLogin } from '../services/UsuarioApi';
import { useNavigate } from 'react-router-dom';

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [token, setToken] = useState(localStorage.getItem('token'));

  let navigate = useNavigate();

  const login = async (username, password) => {
    try {
      const response = await getLogin(username, password);
      const token = response.headers["authorization"];
      setToken(token);
      localStorage.setItem('token', token);
      setUser(username);
      navigate('/Home')
    } catch (error) {
      alert("ERROR", error);
      console.error('Error al iniciar sesión:', error);
    }
  };

  const logout = () => {
    setToken(null);
    localStorage.removeItem('token');
    // opcional: eliminar el usuario del estado del contexto
    setUser(null);
    navigate('/');
  };

 

  return (
    <AuthContext.Provider
      value={{ user, token, login, logout }}
    >
      {children}
    </AuthContext.Provider>
  );
};