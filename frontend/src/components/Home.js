import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import './../assets/styles/styles.css';
import { getCrearLista,getConsultarLista,getBorrarLista} from "./../services/listaReproduccionApi";
import api from "../services/api";

const Home = () => {

    const [nombre, setNombre] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [canciones, setCanciones] = useState([{
        titulo: '',
        artista: '',
        album: '',
        anno: '',
        genero: '',
    }]);
    const [listas, setListas] = useState([]);
    const [listaCanciones, setListaCanciones] = useState([]);

    let navigate = useNavigate();

    function handleLogout(event) {
        event.preventDefault();
        navigate('/');
    }

    const mostrarCanciones = (index) => {
        const listaSeleccionada = listas[index];
        setListaCanciones(listaSeleccionada.canciones);
      };

    const setPlayList = async (event) => {
        event.preventDefault();
        const lista = {
            "nombre": nombre,
            "descripcion": descripcion,
            "canciones": canciones
        };

        try {
            //const response = await api.post('/lists', {nombre,});
            await getCrearLista(nombre,descripcion,canciones).then((response) => {
                console.log('Lista creada con éxito:', response.data);
                setNombre("");
                setDescripcion("");
                setCanciones([]);
              })
              .catch((error) => {
                console.error(error);
              });
            
          } catch (error) {
            console.error('Error al crear la lista:', error);
          }

        /*try {
            const response = await getCrearLista(lista);
            alert("Lista creada");
            console.log('Lista creada con éxito:', response.data);
        } catch (error) {
            alert("ERROR");
            console.error('Error al crear la lista:', error);
        }*/
    };

    const getAllPlayList = async (event) => {
        event.preventDefault();

        

        try {
            const response = await getConsultarLista();
            setListas(response.data);
            
            console.log('Lista consultada con éxito:', response.data);
        } catch (error) {
            alert("ERROR");
            console.error('Error al consultar la lista:', error);
        }
        
    };

    /* const getDescriptionByName = async () => {

        const nombre="Lista 2"
        
        try {
            const response = await getDescripcionByName(nombre);
            setListaCanciones(response.data[0].canciones)
            alert("CONSULTADA");
        } catch (error) {
            alert("ERROR");
            console.error('Error al consultar la lista:', error);
        }
    }; */

    const deletePlayListByName = async (nombre) => {
        console.log("NOMBREEEEE",nombre)

        try {
            const response = await getBorrarLista(nombre);
            alert("Lista eliminada");
            console.log('Lista consultada con éxito:', response.data);
            setListas([]);
            setListaCanciones([]);
            const response2 = await getConsultarLista();
            setListas(response2.data);
        } catch (error) {
            alert("ERROR");
            console.error('Error al consultar la lista:', error);
        }
    };

      const handleCancionChange = (event, index) => {
        const { name, value } = event.target;
        const newCanciones = [...canciones];
        newCanciones[index][name] = value;
        setCanciones(newCanciones);
      };
    
      const addCancion = () => {
        const newCanciones = [...canciones, {
          titulo: '',
          artista: '',
          album: '',
          anno: '',
          genero: '',
        }];
        setCanciones(newCanciones);
      };

    return (
        <div style={{ display: 'flex' }}>
            <button  className='obetenerCanciones' type="button" onClick={handleLogout}>Cerrar sesión</button>
            <div style={{ flex: 1 }}>
                <form onSubmit={setPlayList} className="form">
                    <h3>Lista de reproduccion</h3>
                    <label>
                        Nombre:
                        <input type="text" name="nombre" value={nombre} onChange={(e) => setNombre(e.target.value)} /*required*/ />
                    </label>
                    <br />
                    <label>
                        Descripción:
                        <input type="text" name="descripcion" value={descripcion} onChange={(e) => setDescripcion(e.target.value)} /*required*/ />
                    </label>
                    <br />
                    <h3>Canciones</h3>
                    {canciones.map((cancion, index) => (
                        <div key={index}>
                        <label>
                            Título:
                            <input type="text" name="titulo" value={cancion.titulo} onChange={(e) => handleCancionChange(e, index)} /*required*/ />
                        </label>
                        <br />
                        <label>
                            Artista:
                            <input type="text" name="artista" value={cancion.artista} onChange={(e) => handleCancionChange(e, index)} /*required*/ />
                        </label>
                        <br />
                        <label>
                            Álbum:
                            <input type="text" name="album" value={cancion.album} onChange={(e) => handleCancionChange(e, index)} /*required*/ />
                        </label>
                        <br />
                        <label>
                            Año:
                            <input type="text" name="anno" value={cancion.anno} onChange={(e) => handleCancionChange(e, index)} /*required*/ />
                        </label>
                        <br />
                        <label>
                            Género:
                            <input type="text" name="genero" value={cancion.genero} onChange={(e) => handleCancionChange(e, index)} /*required*/ />
                        </label>
                        <br />
                        <br />
                        </div>
                    ))}
                    <button className='buttonHome' type="button" onClick={addCancion}>Agregar canción</button>
                    <br />
                    <br />
                    <button className='buttonHome' type="submit">Agregar lista</button>
                </form>
                
            </div>
            <button  className='obetenerCanciones' type="button" onClick={getAllPlayList}>Obtener canciones</button>
            <div style={{ flex: 1.5, display:'flex' }}>
                <div>
                {listas.map((lista, index) => (
                    <div className="list-container">
                        <div>
                            <button className='button-lista' key={index} id={`lista-${index}`} onClick={() => mostrarCanciones(index)}>
                            <h2>{lista.nombre}</h2>
                            <p>{lista.descripcion}</p>
                            </button>
                            
                        </div>
                        <div>
                            <button className='button-eliminar' onClick={() => deletePlayListByName(lista.nombre)}>Eliminar lista</button>
                        </div>
                        
                        
                    </div>
                    
                
                ))}
                </div>
                 
                <div>
                        {listaCanciones.length > 0 && (
                        <ul>
                            {listaCanciones.map((cancion, index) => (
                                <li key={index} className="list-item">
                                <h3>Titulo: {cancion.titulo}</h3>
                                <p>Artista: {cancion.artista}</p>
                                <p>Album: {cancion.album}</p>
                                <p>Año: {cancion.anno}</p>
                                <p>Género:{cancion.genero}</p>
                                </li>
                            ))}
                        </ul>)}
                        </div>               
                
            </div>
        </div>       
  
    );
};

export default Home;