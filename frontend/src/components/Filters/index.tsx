import React from "react";
import {Link} from "react-router-dom";

type Props = {

    link: String;
    linkText: string;

}


const Filters = ({link, linkText}: Props) => (

    <div className="filters-container records-actions">
        <Link to="/charts">
            <button className="action-filters">
                {linkText}
            </button>
        </Link>
    </div>

);

export default Filters;