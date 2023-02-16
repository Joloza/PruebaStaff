import axios from 'axios';

export const getLogin = (credenciales) => {
    return axios.post('http://localhost:8081/login',credenciales);
}

export const getCrearLista = (lista) => {
  return axios.post('http://localhost:8081/lists',lista);
}

export const getConsultarLista = () => {
    return axios.get('http://localhost:8081/lists');
}

export const getDescripcionByName = (nombre) => {
    return axios.get(`http://localhost:8081/lists/listName?nombre=${nombre}`);
}

export const getBorrarLista = (nombre) => {
    return axios.delete(`http://localhost:8081/lists/listName?nombre=${nombre}`);
}