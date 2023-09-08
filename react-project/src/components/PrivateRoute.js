import React, { useState } from "react";
import {Route} from "react-router-dom";
import { useLocalState } from "./UseLocalStorage";
import { Navigate } from "react-router-dom";

const PrivateRoute = ( {children} ) => {
    // children are the props that are passed from the parent component
    const [jwt, setJwt] = useLocalState("", "jwt");
    return jwt ? children : <Route to="/login"/>;
}

export default PrivateRoute;