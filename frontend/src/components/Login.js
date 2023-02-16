import React, {useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {getRegistrarUsuario,getLogin} from "./../services/listaReproduccionApi";
import './../assets/styles.css';


const Login=()=>{

    const [nombre, setNombre] = useState('');
    const [contrasena, setContrasena] = useState('');

    let navigate = useNavigate();

    function handleNameChange(event) {
        setNombre(event.target.value);
    }

    function handleContrasenaChange(event) {
        setContrasena(event.target.value);
    }

    const setUser = async () => {
        const datos = {
            "nombre": "admin",
            "contrasena":"123"
        };
        try {
            const response = await getRegistrarUsuario(datos);
            alert("Usuario creado");
            console.log('Usuario creado:', response.data);
        } catch (error) {
            console.error('Error al crear usuario:', error);
        }
    };

    const loginUser = async () => {
        const datos = {
            nombre: nombre,
            contrasena: contrasena
        };
        try {
            const response = await getLogin(datos);
            const token = response.data;
            localStorage.setItem('token', token);
            navigate('/Home');
            return token;
        } catch (error) {
            alert("ERROR", error);
            console.error('Error al iniciar sesión:', error);
        }
    }

  const onSubmit = ( event ) => {
    event.preventDefault();
    loginUser();
}

    return(
        

        <div className="formLogin">
            <label>1-Se debe registrar el usuario para poder acceder </label>
            <input className="buttonHome" type="submit" value="Registrar usuario" onClick={setUser}/>
            <form onSubmit={(onSubmit)}>
                <div className="input-container">
                    <label>Nombre </label>
                    <input type="text" name="nombre" required onChange={ handleNameChange } placeholder="admin"/>
                </div>
                <div className="input-container">
                    <label>Contraseña </label>
                    <input type="password" name="contrasena" required onChange={ handleContrasenaChange } placeholder="123"/>
                </div>
                <div className="button-container">
                    <input type="submit" />
                </div>
            </form>
            
        </div>
        
    );
}

export default Login;