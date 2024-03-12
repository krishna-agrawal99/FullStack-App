import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "/node_modules/bootstrap/dist/js/bootstrap.min.js";

import './App.css';
import Home from './compents/Home';
import StudentView from './compents/student/StudentView';
import NavBar from "./compents/common/NavBar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddStudent from "./compents/student/AddStudent";
import EditStudent from "./compents/student/EditStudent";



function App() {
  return (
    <main className="container mt-5">
      <Router>
        <NavBar />
        <Routes>
          <Route exact path="/" element={<Home />}>

          </Route>
          <Route exact
            path="/view-students"
            element={<StudentView />}>
          </Route>

          <Route exact
            path="/add-students"
            element={<AddStudent />}>
          </Route>

          <Route exact
            path="/edit-student/:id"
            element={<EditStudent />}>
          </Route>

        </Routes>
      </Router>


    </main>
  );
}

export default App;
