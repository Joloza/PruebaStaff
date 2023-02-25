import React, { Fragment } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from "./../components/Login";
import Home from './../components/Home';
import UserRegister from '../components/UserRegister';

function App() {
  return (
    <div className='App'>
      <Fragment>
        <Router>
          <Routes>
            <Route path='/' exact element={ <UserRegister /> } /> 
            <Route path='/login'  element={ <Login /> } />             
            <Route path='/home'  element={ <Home /> } />            
          </Routes>
        </Router>
      </Fragment>
    </div>
  );
}

export default App;