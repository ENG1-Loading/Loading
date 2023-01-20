import React from "react";
import { Routes ,Route } from 'react-router-dom';
import App from "./pages/WeeklyNotes";
import Homepage from "./pages/Homepage";
import RiskAssesment from "./pages/RiskManagement";
const Main = () => {
    return (
        <Routes>
            <Route exact path="/" element={<App />}></Route>
            <Route exact path="/home" element={<Homepage />}></Route>
            <Route exact path="/risk_assessment" element={<RiskAssesment />}> </Route>
        </Routes>
    )
}
export default Main;