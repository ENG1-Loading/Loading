import React, {useEffect} from "react"
import anime from "animejs"

import IconLoader from "./LogoSVG"
import {Link} from "react-router-dom";

const Logo = () => {
    const animate = () => {
        const loader = anime.timeline({
            loop: true,
        })

        loader
            .add({
                targets: "#logo #clip0",
                delay: 300,
                duration: 1500,
                easing: "easeInOutQuart",
                strokeDashoffset: [anime.setDashoffset, 0],
            })
            .add({
                targets: "#logo #B",
                duration: 700,
                easing: "easeInOutQuart",
                opacity: 1,
            })
            .add({
                targets: "#logo",
                delay: 500,
                duration: 300,
                easing: "easeInOutQuart",
                opacity: 0,
                scale: 0.4,
            })
            .add({
                targets: ".loader",
                duration: 200,
                easing: "easeInOutQuart",
                opacity: 1,
                zIndex: -1,
            })
    }

    useEffect(() => {
        const timeout = setTimeout(() => {
        }, 1)
        animate()
        return () => clearTimeout(timeout)
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [])

    return (

    <Link to={'/'} className={'logo-wrapper'}>
        <IconLoader/>
    </Link>

)
}


export default Logo