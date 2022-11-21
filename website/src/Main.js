import React from "react";
import { Routes ,Route } from 'react-router-dom';
import App from "./pages/WeeklyNotes";
import Homepage from "./pages/Homepage";
const Main = () => {
    return (
        <Routes>
            <Route exact path="/" element={<App />}></Route>
            <Route exact path="/home" element={<Homepage />}></Route>
        </Routes>
    )
}
export default Main;