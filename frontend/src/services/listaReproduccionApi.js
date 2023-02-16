import axios from 'axios';

export const getRegistrarUsuario = (datos) => {
    return axios.post('http://localhost:4000/registrarUsuario',datos);
}

export const getLogin = (credenciales) => {
    return axios.post('http://localhost:4000/login',credenciales);
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