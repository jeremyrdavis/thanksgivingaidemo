import {useState} from "react";
import { Region } from "./components/Region";
import { Register } from "./components/Register";
import {DarkThemeToggle} from "flowbite-react";

function App() {

        const [workflow, setWorkflow] = useState({
                email: null,
        });

        const updateWorkflow = async (workflow) => {
                setWorkflow({
                        email: workflow.email,
                });
                console.log("after update workflow: ", workflow);
        }

        return (
              <main className="flex min-h-screen items-center justify-center gap-2 dark:bg-gray-800">
                  <h1 className="text-2xl dark:text-white">Flowbite React + Vite</h1>
                  <DarkThemeToggle/>
                      {/* <Register updateWorkflow={updateWorkflow}/> */}
                      <Region email={workflow.email} updateWorkflow={updateWorkflow}/>
                  </main>
       );
  }

export default App;
