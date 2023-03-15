import React, {useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {getRegistrarUsuario} from "../services/UsuarioApi";
import '../assets/styles/fonts.css'
import '../assets/styles/styles.css'

const UserRegister=()=>{

    const [nombre, setNombre] = useState('');
    const [contrasena, setContrasena] = useState('');
    const [validateAlert, setValidateAlert] = useState('');

    let navigate = useNavigate();

    const nombreChange=(event)=>{
        setNombre(event.target.value);
    }

    const contrasenaChange=(event)=>{
        setContrasena(event.target.value);
    }

    const userRegister=async(event)=>{
        event.preventDefault();
        
        try {
            const response = await getRegistrarUsuario(nombre,contrasena);
            setValidateAlert(response.data);
            console.log('Usuario creado:', response.data);
            navigate('/');
        } catch (error) {
            console.error('Error al crear usuario:', error);
        }
    }

    return(
        <div>
            <form onSubmit={(userRegister)}>
                <div className="input-container">
                    <label>Nombre </label>
                    <input type="text" name="nombre" required value={nombre} onChange={ nombreChange } placeholder="Nombre de usuario"/>
                </div>
                <div className="input-container">
                    <label>Contraseña </label>
                    <input type="password" name="contrasena" required value={contrasena} onChange={ contrasenaChange } placeholder="Contraseña"/>
                </div>
                <div className="button-container">
                    <input type="submit" />
                </div>
            </form>            
        </div>
    );

}

export default UserRegister;
