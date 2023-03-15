import React, {useState, useContext, useEffect} from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../auth/AuthContext';
import '../assets/styles/fonts.css'
import '../assets/styles/styles.css'

/*localStorage.clear();
const token = localStorage.getItem('token');
console.log(token);*/
 
const Login=()=>{

    const [nombre, setNombre] = useState('');
    const [contrasena, setContrasena] = useState('');

    const { login, token } = useContext(AuthContext);
    let navigate = useNavigate();

    function handleNameChange(event) {
        setNombre(event.target.value);
    }

    function handleContrasenaChange(event) {
        setContrasena(event.target.value);
    }

    function handleGoRegister(event) {
        event.preventDefault();
        navigate('/UserRegister');
    }

    const loginUser = async () => {
        /* try {
            const response = await getLogin(nombre,contrasena);
            const token = response.headers["authorization"];
            const token2 = localStorage.getItem('token');
            console.log("TOKEN",token);
            console.log("TOKEN2",token2);
            //localStorage.setItem('token', token);
            auth.setToken(token);
            
            //navigate('/Home');
            //return token;
        } catch (error) {
            alert("ERROR", error);
            console.error('Error al iniciar sesión:', error);
        } */

        //await handleUserLogin(nombre,contrasena);
    }

    const onSubmit = async ( event ) => {
        event.preventDefault();
        //handleUserLogin(nombre,contrasena);
        //loginUser();
        await login(nombre,contrasena)
    }

    useEffect(() => {

        console.log("TOKEN",token)

        if(token==null){
            navigate('/');
        }else if(token!=null){
            navigate('/Home');
        }

        /* return (
        ); */
        
    }, []);

    return(
        <div className="formLogin">
            <form onSubmit={(onSubmit)}>
                <div className="input-container">
                    <label>Nombre </label>
                    <input type="text" name="nombre" required onChange={ handleNameChange } placeholder=""/>
                </div>
                <div className="input-container">
                    <label>Contraseña </label>
                    <input type="password" name="contrasena" required onChange={ handleContrasenaChange } placeholder=""/>
                </div>
                <div className="button-container">
                    <input type="submit" />
                </div>
            </form>

            <div>
                <button className='button-eliminar' onClick={handleGoRegister}>Register</button>
            </div>
            
        </div>
        
    );
}

export default Login;