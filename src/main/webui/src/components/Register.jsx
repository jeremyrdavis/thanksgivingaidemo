import {Button, Label, TextInput} from "flowbite-react";

export function Register({updateWorkflow}) {
    return (
        <div>
                <form id="registerform" className="flex max-w-md flex-col gap-4"
                      onSubmit={(e) => {
                        e.preventDefault();
                        const emailAddress = e.target.email.value;
                        console.log(emailAddress);
                        updateWorkflow(emailAddress);
                    }}>
                    <div>
                        <div className="mb-2 block">
                            <Label htmlFor="email" value="Enter your email to get started"/>
                        </div>
                        <TextInput id="email" type="email" placeholder="name@flowbite.com" required />
                    </div>
                    <Button type="submit">Register</Button>
            </form>
        </div>
    );
}
