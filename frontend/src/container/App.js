import React, { Fragment } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from "./../pages/Login";
import Home from './../pages/Home';
import UserRegister from '../pages/UserRegister';
import { AuthProvider } from '../auth/AuthContext';

function App() {
  return (
    <div className='App'>
      
        <Fragment>
        
          <Router>
          <AuthProvider>
            <Routes>
              <Route path='/' exact element={ <Login /> } />   
              <Route path='/userRegister' element={ <UserRegister /> } />
              <Route path='/home'  element={<Home />} />                             
             </Routes>
             </AuthProvider> 
          </Router>
          
        </Fragment>
      
    </div>
  );
}

export default App;