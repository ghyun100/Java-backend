import { Dispatch, SetStateAction } from "react";

interface Props {
    label: string;
    type: string;
    name: string;
    setter: Dispatch<SetStateAction<string>>;
    maxLength: number;
    iconClass: string;
}

export default function NaverInput(props: Props) {
    const { label, type, name, maxLength, iconClass, setter } = props;

    return (
        <div className="input-row">
            <div className="icon-cell">
                <span className={iconClass}>
                    <span className="blind">{label}</span>
                </span>
            </div>
            <input
                type={type}
                className="input-text"
                maxLength={maxLength}
                placeholder={label}
                name={name}
                onChange={(event) => setter(event.target.value)}
            />
        </div>
    );
}