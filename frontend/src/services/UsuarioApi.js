import axios from 'axios';

export const getRegistrarUsuario = (nombre,contrasena) => {
    return axios.post('http://localhost:4000/registrarUsuario',{nombre,contrasena});
}