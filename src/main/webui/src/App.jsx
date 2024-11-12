import {useState} from "react";
import ThanksgivingMenu from "./components/ThanksgivingMenu";
import { Region } from "./components/Region";
import { Register } from "./components/Register";
import { CurrentState } from "./components/CurrentState";
import {DarkThemeToggle} from "flowbite-react";

const menuUrl = 'http://localhost:8080/thanksgivingai/menu';


function App() {

        const [step, setStep] = useState(1);
        const [email, setEmail] = useState("");
        const [stateCodes, setStateCodes] = useState([]);
        const[thanksgivingMenu, setThanksGivingMenu] = useState({
                mains: ["Turkey", "Ham", "Tofurkey"],
                sides: ["Mashed Potatoes", "Green Beans", "Cranberry Sauce", "Mac & Cheese", "Sweet Potatoes", "Rolls"]
        });

        const updateEmail = async (emailAddress) => {
                console.log(emailAddress);
                setEmail(emailAddress);
                setStep(2);
        }

        const updateStateCodes = async (s) => {
                console.log("updateStateCodes: states=" + s);
                setStateCodes(s);
                setStep(3);
        }

        const createInvitation = async () => {
                console.log("createInvitation");
                console.log(JSON.stringify(thanksgivingMenu));
                const response = await fetch(menuUrl, {
                        method: 'POST',
                        // headers: {
                        //         'Content-Type': 'application/json'
                        // },
                        // body: JSON.stringify(thanksgivingMenu)
                });
                const data = await response.json();
                console.log(data);
                return data;
        }

        const logWorkflow = (msg) => {
                console.log(msg);
                console.log("email: ", email);
                console.log("stateCodes: ", stateCodes);
        }

        return (
              <main className="flex min-h-screen items-center justify-center gap-2 dark:bg-gray-800">
                  <h1 className="text-2xl dark:text-white">Flowbite React + Vite</h1>
                  <DarkThemeToggle/>
                      {step === 1 && <Register updateWorkflow={updateEmail}/>}
                      {step === 2 && <Region callback={updateStateCodes}/>}
                      {step === 3 && <ThanksgivingMenu thanksgivingMenu={thanksgivingMenu} invitationCallback={createInvitation}/> }
                  </main>
       );
  }

export default App;
