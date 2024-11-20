import { useState } from "react";
import { Flowbite } from "flowbite-react";
import ThanksgivingMenu from "./components/ThanksgivingMenu";
import Region from "./components/Region";
import Register from "./components/Register";
import ThanksgivingInvitation from "./components/ThanksgivingInvitation";

const menuUrl = 'http://localhost:8080/static/thanksgiving-menu-01.png';
const invitationUrl = 'http://localhost:8080/api/ai/invitation';
const getMenuUrl = 'http://localhost:8080/api/ai/menu';

function App() {

        const [step, setStep] = useState(1);
        const [email, setEmail] = useState("");
        const [stateCodes, setStateCodes] = useState([]);
        const [thanksgivingMenu, setThanksGivingMenu] = useState({
                mains: [{
                        "item": "Turkey",
                        "description": "Brined, Oven Roasted"
                },
                        {
                                "item": "Tofurkey",
                                "description": "Vegan"
                        }],
                sides: [                      {
                        "item": "Mac & Cheese",
                        "description": "Gooey, Cheesy"
                },
                        {
                                "item": "Green Bean Casserole",
                                "description": "Like Grandma used to make"
                        },
                        {
                                "item": "Squash",
                                "description": "Roasted"
                        }
                ],
                desserts: [{
                        "item": "Pumpkin Pie",
                        "description": "Traditional"
                }]
        });
        const [invitation, setInvitation] = useState();

        const updateEmail = async (emailAddress) => {
                console.log(emailAddress);
                setEmail(emailAddress);
                setStep(2);
        }

        const updateStateCodes = async (s) => {
                console.log("updateStateCodes: states=" + s);
                console.log("getMenu: states=" + s);
                let payload = JSON.stringify({email : email, stateCodes: s});
                console.log("payload: ", payload);
                const response = await fetch(getMenuUrl, {
                        method: 'POST',
                        headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                        },
                        body: payload
                });
                const data = await response.json();
                console.log(data);
                setThanksGivingMenu(data);
                setStep(3);
        }

        const createInvitation = async () => {
                console.log("createInvitation");
                let createInvitationCommand = {
                        thanksgivingMenuRecord: thanksgivingMenu
                }
                console.log("createInvitationCommand: ", JSON.stringify(createInvitationCommand));
                const response = await fetch(invitationUrl, {
                        method: 'POST',
                        headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json',
                        },
                        body: JSON.stringify(createInvitationCommand)
                });
                const data = await response.json();
                console.log("invitation result: " + data);
                console.log("invitation menu: " + data.thanksgivingMenu);
//                setInvitation({"invitationUrl": "public/thanksgiving-menu-01.png", thanksgivingMenu});
                setInvitation(data);
                setStep(4);
        }

        const createPdf = async () => {
                console.log("createPdf");
        }

        const logWorkflow = (msg) => {
                console.log(msg);
                console.log("email: ", email);
                console.log("stateCodes: ", stateCodes);
        }

        const getMenu = async (s) => {
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
