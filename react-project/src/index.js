import React from 'react';
// make it aware of different routs
import {BrowserRouter} from "react-router-dom";
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    // app is a component
    // the only component being rendered is app
    <BrowserRouter>
        <App />
    </BrowserRouter>
);


