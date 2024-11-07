import {Button, Label, List, Select} from "flowbite-react";

export default function ThanksgivingMenu(props) {

    const thanksgivingMenu = props.thanksgivingMenu;
    console.log("ThanksgivingMenu: ", thanksgivingMenu);

    return (
    <div>
            <form id="menuForm" className="flex max-w-md flex-col gap-4"
                  onSubmit={(e) => {
                      e.preventDefault();
                      callback(selectedStates);
                  }}>
                <div className="max-w-md">
                    <div className="mb-2 block">
                        <List>
                            {thanksgivingMenu.mains.map((main) => (
                                <List.Item>{main}</List.Item>
                            ))}
                        </List>
                        <List>
                            {thanksgivingMenu.sides.map((side) => (
                                <List.Item>{side}</List.Item>
                            ))}
                        </List>
                    </div>
                </div>
                <Button type="submit">Continue</Button>
            </form>
        </div>
    );

}