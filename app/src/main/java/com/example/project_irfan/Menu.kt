package com.example.project_irfan

class Menu {

    companion object {
        fun buatSetData(): ArrayList<ListObjMenu> {
            val list = ArrayList<ListObjMenu>()
            list.add(
                ListObjMenu(
                    "Summer",
                    "Coffee Beer",
                    "Minuman dari Ballins Coffee",
                    "17.000",
                    "@drawable/menu1",
                )
            )
            list.add(
                ListObjMenu(
                    "Summer",
                    "Coffee Latte",
                    "Minuman dari Ballins Coffee",
                    "17.000",
                    "@drawable/menu1",
                )
            )
            list.add(
                ListObjMenu(
                    "Summer",
                    "Hazelnut Latte",
                    "Minuman dari Ballins Coffee",
                    "17.000",
                    "@drawable/menu1",
                )
            )
            list.add(
                ListObjMenu(
                    "Summer",
                    "Caramel Latte",
                    "Minuman dari Ballins Coffee",
                    "17.000",
                    "@drawable/menu1",
                )
            )
            list.add(
                ListObjMenu(
                    "Botol",
                    "Coffe Latte - Botol",
                    "Minuman dari Ballins Coffee",
                    "25.000",
                    "@drawable/menu1",
                )
            )
            list.add(
                ListObjMenu(
                    "Botol",
                    "Machiato - Botol",
                    "Minuman dari Ballins Coffee",
                    "25.000",
                    "@drawable/menu1",
                )
            )
            list.add(
                ListObjMenu(
                    "Botol",
                    "Coffee Beer- Botol",
                    "Minuman dari Ballins Coffee",
                    "25.000",
                    "@drawable/menu1",
                )
            )
            list.add(
                ListObjMenu(
                    "Botol",
                    "Hazelnut Latte - Botol",
                    "Minuman dari Ballins Coffee",
                    "25.000",
                    "@drawable/menu1",
                )
            )

            return list
        }
    }
}