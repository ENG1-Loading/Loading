import React from "react";
import { Routes ,Route } from 'react-router-dom';
import App from "./pages/WeeklyNotes";
const Main = () => {
    return (
        <Routes>
            <Route exact path="/" element={<App />}></Route>
        </Routes>
    )
}
export default Main;