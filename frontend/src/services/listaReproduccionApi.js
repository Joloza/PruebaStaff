import axios from 'axios';
import api from './api';

/* export const getLogin = (nombre,contrasena) => {
    return axios.post('http://localhost:4000/login',{nombre,contrasena});
} */

/* export const getCrearLista = (lista) => {
  return axios.post('http://localhost:4000/lists',lista);
} */

export const getCrearLista = (nombre,descripcion,canciones) => {
    console.log("TOKEN 2",localStorage.getItem('token'));
    return api.post('/lists',{nombre,descripcion,canciones});
    /* .then((response) => {
      console.log(response.data);
    })
    .catch((error) => {
      console.error(error);
    }) */;
}

export const getConsultarLista = () => {
    return api.get('/lists');
}

export const getDescripcionByName = (nombre) => {
    return axios.get(`http://localhost:4000/lists/listName?nombre=${nombre}`);
}

export const getBorrarLista = (nombre) => {
    //return api.delete(`/lists/listName?nombre=${nombre}`);
    return api.delete(`/lists/listName?nombre=${nombre}`);
    //return api.delete('/lists/listName',nombre);
}

export const getToken=()=>{
    return localStorage.getItem("token");
}