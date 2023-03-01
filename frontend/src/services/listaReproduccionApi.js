import axios from 'axios';

export const getLogin = (nombre,contrasena) => {
    return axios.post('http://localhost:4000/login',{nombre,contrasena});
}

export const getCrearLista = (lista) => {
  return axios.post('http://localhost:4000/lists',lista);
}

export const getConsultarLista = () => {
    return axios.get('http://localhost:4000/lists');
}

export const getDescripcionByName = (nombre) => {
    return axios.get(`http://localhost:4000/lists/listName?nombre=${nombre}`);
}

export const getBorrarLista = (nombre) => {
    return axios.delete(`http://localhost:4000/lists/listName?nombre=${nombre}`);
}

export const getToken=()=>{
    return localStorage.getItem("token");
}