import {Button, Label, List, Select} from "flowbite-react";

export default function ThanksgivingInvitation({ invitation, invitationCallback }) {

        console.log("invitationCallback: ", invitationCallback);
        console.log("ThanksgivingMenu: ", invitation.thanksgivingMenu);
        console.log("Invitation URI: ", invitation.invitationUri);
        let thanksgivingMenu = invitation.thanksgivingMenu;

        return (
        <div>
            <div>
                <img src={invitation.invitationUri} alt="Thanksgiving Invitation" className="w-full" />
            </div>
                <form id="menuForm" className="flex max-w-md flex-col gap-4"
                    onSubmit={(e) => {
                        e.preventDefault();
                        invitationCallback();
                    }}>
                    <div className="max-w-md">
                        <div className="mb-2 block">
                            <List>
                                {thanksgivingMenu.mains.map((main) => (
                                    <List.Item key={main}>{main}</List.Item>
                                ))}
                            </List>
                            <List>
                                {thanksgivingMenu.sides.map((side) => (
                                    <List.Item key={side}>{side}</List.Item>
                                ))}
                            </List>
                            <List>
                                {thanksgivingMenu.desserts.map((dessert) => (
                                    <List.Item key={dessert}>{dessert}</List.Item>
                                ))}
                            </List>
                        </div>
                    </div>
                    <Button type="submit">Would You Like a PDF of Your Invitation?</Button>
                </form>
            </div>
        );
}