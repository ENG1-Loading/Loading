import React from "react";
import { Routes ,Route } from 'react-router-dom';
import App from "./pages/test";
const Main = () => {
    return (
        <Routes>
            <Route exact path="/test" element={<App />}></Route>
        </Routes>
    )
}
export default Main;