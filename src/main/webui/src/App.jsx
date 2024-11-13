import { useState } from "react";
import { Flowbite } from "flowbite-react";
import ThanksgivingMenu from "./components/ThanksgivingMenu";
import Region from "./components/Region";
import Register from "./components/Register";
import ThanksgivingInvitation from "./components/ThanksgivingInvitation";

const menuUrl = 'http://localhost:8080/static/thanksgiving-menu-01.png';
const invitationUrl = 'http://localhost:8080/thanksgivingai/invitation';

function App() {

        const [step, setStep] = useState(1);
        const [email, setEmail] = useState("");
        const [stateCodes, setStateCodes] = useState([]);
        const [thanksgivingMenu, setThanksGivingMenu] = useState({
                mains: ["Turkey", "Ham", "Tofurkey"],
                sides: ["Mashed Potatoes", "Green Beans", "Cranberry Sauce", "Mac & Cheese", "Sweet Potatoes", "Rolls"],
                desserts: ["Pumpkin Pie", "Coconut Cake"]
        });
        const [invitation, setInvitation] = useState();

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
                let createMenuCommand = {
                        thanksgivingMenu: thanksgivingMenu
                }
                const requestPayload = JSON.stringify(createMenuCommand);
                console.log("requestPayload: ", requestPayload);
                const response = await fetch(invitationUrl, {
                        method: 'POST',
                        headers: {
                                'Content-Type': 'application/json',
                                'Origin': 'http://localhost:3000'
                        },
                        body: requestPayload
                });
                const data = await response.json();
                console.log(data);
                setInvitation(data);
                setStep(4);
        }

        const createPdf = async () => {
                log.console("createPdf");
        }

        const logWorkflow = (msg) => {
                console.log(msg);
                console.log("email: ", email);
                console.log("stateCodes: ", stateCodes);
        }

        return (
            <Flowbite theme={{ mode: 'dark' }}>
              <main className="flex min-h-screen items-center justify-center gap-2 dark:bg-gray-800">
                      {step === 1 && <Register updateWorkflow={updateEmail}/>}
                      {step === 2 && <Region callback={updateStateCodes}/>}
                      {step === 3 && <ThanksgivingMenu thanksgivingMenu={thanksgivingMenu} invitationCallback={createInvitation}/> }
                      {step === 4 && <ThanksgivingInvitation invitation={invitation} invitationCallback={createPdf}/>}
                  </main>
            </Flowbite>
       );
  }

export default App;
