import React from "react";
import { Routes ,Route } from 'react-router-dom';
import App from "./pages/WeeklyNotes";
import Homepage from "./pages/Homepage";
import RiskAssessment from "./pages/RiskManagement";
import VersionControl from "./pages/VersionControl";
import NotFound from "./pages/NotFound";
import Architecture from "./SharedComponents/architecture/Architecture";
import Deliverables from "./pages/Deliverables";
const Main = () => {
    return (
        <Routes>
            <Route exact path="/" element={<Homepage />}></Route>
            <Route exact path="/notes" element={<App />}></Route>
            <Route exact path="/risk_assessment" element={<RiskAssessment />}> </Route>
            <Route exact path="/version_control" element={<VersionControl />}></Route>
            <Route exact path="/architecture" element={<Architecture />}></Route>
            <Route exact path="/deliverables" element={<Deliverables />}></Route>

        {/*    404*/}
            <Route path="*" element={<NotFound />}></Route>
        </Routes>
    )
}
export default Main;
