import React, { Fragment } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
//import '../assets/styles/App.css';
import Login from "./../components/Login"
import Home from './../components/Home';

function App() {
  return (
    <div className='App'>
      <Fragment>
        <Router>
          <Routes>
            <Route path='/' exact element={ <Login /> } />
            <Route path='/home' exact element={ <Home /> } />            
          </Routes>
        </Router>
      </Fragment>
    </div>
  );
}

export default App;