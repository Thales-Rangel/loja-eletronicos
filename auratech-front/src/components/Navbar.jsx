function Navbar() {

    return (
        <nav className="w-full pl-80 pr-80 bg-emerald-500 text-white">
            <div className="flex justify-center items-center">
                <div>
                    <h1 className="saira-sans">AuraTech</h1>
                </div>
                <div className=" flex tems-center justify-center w-full ml-10">
                    <input type="text" className="w-full outline-1 bg-white text-black" placeholder="Pesquise aqui" />
                    <span class="material-symbols-outlined">
                        search
                    </span>
                </div>
                <div className="flex w-100 pl-5 pr-5">
                    <ul className="flex justify-between w-full">
                        <li>
                            <a href="">Perfil</a>
                        </li>
                        <li>
                            <a href="">Compras</a>
                        </li>
                        <li>
                            <a href=""><span class="material-symbols-outlined">
                                shopping_cart
                            </span></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div className="flex justify-between">
                <div>
                    <a href="">Endereço</a>
                </div>
                <div>
                    <a href="">Ofertas</a>
                </div>
                <div>
                    <a href="">Cupons</a>
                </div>
                <div>
                    <a href="">Contato</a>
                </div>
                <div>
                    <a href="">Wireless e IoT</a>
                </div>
                <div>
                    <a href="">Mais categorias</a>
                </div>
            </div>
        </nav >
    )

}

export default Navbar;