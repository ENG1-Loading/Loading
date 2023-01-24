import React from "react";
import { Routes ,Route } from 'react-router-dom';
import WeeklyNotes from "./pages/WeeklyNotes";
import Homepage from "./pages/Homepage";
import RiskAssesment from "./pages/RiskManagement";
import NotFound from "./pages/NotFound";
const Main = () => {
    return (
        <Routes>
            <Route exact path="/" element={<Homepage />}></Route>
            <Route exact path="/weekly_notes" element={<WeeklyNotes />}></Route>
            <Route exact path="/risk_assessment" element={<RiskAssesment />}> </Route>
        {/*    not found 404*/}
            <Route path={"*"} element={<NotFound/>}></Route>
        </Routes>
    )
}
export default Main;