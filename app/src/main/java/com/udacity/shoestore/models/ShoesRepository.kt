package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ShoesRepository {

    companion object {
        val instance by lazy { ShoesRepository() }
    }

    private val shoeList = createInitialData()

    private val shoeListData: MutableLiveData<List<Shoe>> by lazy {
        MutableLiveData(shoeList)
    }

    // return all data
    fun getShoesList(): LiveData<List<Shoe>> = shoeListData

    // return item details by id
    fun getShoe(shoeId: String): LiveData<Shoe> {
        val shoe = shoeList.firstOrNull { it.shoeId == shoeId }

        return MutableLiveData(shoe)
    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(0, shoe)
        shoeListData.value = shoeList
    }

    private fun createInitialData() = mutableListOf(
            Shoe("1", "Cross country running shoes","5.0 - 12.0", "Nike", "Cross country running shoes are made for cross country running, a form of long distance running. Season-specific trainers are available for different types of training."),
            Shoe("2", "Ballet shoes", "6.0 - 13.0", "Capezio", "A ballet shoe, or ballet slipper, is a lightweight shoe designed specifically for ballet dancing. It may be made from soft leather, canvas, or satin, and has flexible, thin full or split soles. Traditionally, women wear pink shoes and men wear white or black shoes. Skin colored slippers—which are unobtrusive and thus give the appearance of dancing barefoot—are worn in modern ballets and sometimes modern dancing by both men and women.Typically, in a ballet class, male dancers wear ballet slippers throughout the class whereas female dancers wear ballet slippers at the beginning and then may change into pointe shoes."),
            Shoe("3", "Bast shoes", "5.0 - 12.0", "Handmade", "Bast shoes are shoes made primarily from bast — fiber taken from the bark of trees such as linden. They are a kind of basket, woven and fitted to the shape of a foot. Bast shoes are an obsolete traditional footwear of the forest areas of Northern Europe, formerly worn by poorer members of the Finnic peoples, Balts, Russians, Ukrainians and Belarussians. They were easy to manufacture, but not durable. Similar shoes have also been made of strings of birchbark in more northern areas where bast is not readily available."),
            Shoe("4", "Blucher shoes", "5.0 - 14.0", "Blucher shoes", "Blucher is a style of shoe with open lacing, its vamp made of a single piece of leather, with shoelace eyelets tabs sewn on top. The blucher is similar to a derby: both feature open lacing, in contrast to the Oxford shoe, which uses close lacing, but in the derby the upper has large quarters with eyelets sewn on top, while in the blucher the upper is made of one cut, with only the small eyelet tabs sewn on top."),
            Shoe("5", "Boat shoes", "6.0 - 13.0", "Clarks", "Boat shoes (also known as deck shoes) are typically canvas or leather with non-marking rubber soles designed for use on a boat. A siping pattern is cut into the soles to provide grip on a wet deck; the leather construction, along with the application of oil, is designed to repel water; and the stitching is highly durable. Boat shoes are traditionally worn without socks"),
            Shoe("6", "Brogan shoes", "5.0 - 14.0", "Missouri Boot & Shoe Company", "Brogan-like shoes, called \"brogues\", were made and worn in Scotland and Ireland as early as the 16th century, and the shoe-type probably originated there. They were used by the Scots and the Irish as work boots for wear in the wet, boggy Scottish and Irish countryside. The word \"brogue\" is still used in Britain for a style of dress shoe, which may or may not have an ankle high top."),
            Shoe("8", "Brogue shoes", "5.0 - 12.0", "Herring", "The brogue is a style of low-heeled shoe or boot traditionally characterised by multiple-piece, sturdy leather uppers with decorative perforations and serration along the pieces' visible edges. Brogues were traditionally considered to be outdoor or country footwear not otherwise appropriate for casual or business occasions, but brogues are now considered appropriate in most contexts"),
            Shoe("10", "Chelsea boots", "6.0 - 15.0", "Aldo", "Chelsea boots are close-fitting, ankle-high boots with an elastic side panel. They often have a loop or tab of fabric on the back of the boot, enabling the boot to be pulled on. The boot dates back to the Victorian era, when it was worn by both men and women.Chelsea boots and some of its variants were considered an iconic element of the 1960s in Britain, particularly the mod scene."),
            Shoe("11", "Chukka boots", "5.0 - 14.0", "Thursday Boot", " Chukka boots are ankle-high leather boots with suede or leather uppers, leather or rubber soles, and open lacing with two or three pairs of eyelets. The name chukka possibly comes from the game of polo, where a chukka is a period of play. Generally, \"chukka boot\" refers to a form of desert boots originally worn by British soldiers in the Western Desert Campaign of World War II."),
            Shoe("12", "Clogs", "6.0 - 15.0", "Bryr Studio", "Clogs are a type of footwear made in part or completely from wood. Clogs are used worldwide and although the form may vary by culture, within a culture the form often remained unchanged for centuries. Traditional clogs remain in use as protective footwear in agriculture and in some factories and mines. Although clogs are sometimes negatively associated with cheap and folkloric footwear of farmers and the working class, some types of clogs are considered fashion wear today, such as Swedish träskor or Japanese geta."),
            Shoe("13", "Derby shoe", "5.0 - 14.0", "Derby Shoe Company", " A derby is a style of boot or shoe characterized by quarters, with shoelace eyelets that are sewn on top of the vamp. This construction method, also known as \"open lacing\", contrasts with that of the Oxford shoe"),
            Shoe("14", "Dress shoes", "5.0 - 12.0", "Allen Edmonds", "Dress Shoe is a shoe to be worn at smart casual or more formal events. A dress shoe is typically contrasted to an athletic shoe.Dress shoes are worn by many as their standard daily shoes, and are widely used in dance, for parties, and for special occasions. Mens dress shoes are most commonly black or brown. Cordovan or oxblood dress shoes are worn by men sometimes in the United States, while the other colors are worn by men of many nationalities."),
            Shoe("17", "Fashion boots", "5.0 - 14.0", "LOFT", "A fashion boot is a boot worn for reasons of style or fashion (rather than for utilitarian purposes – e.g. not hiking boots, riding boots, rain boots, etc.). The term is usually applied to women's boots. Fashion boots come in a wide variety of styles, from ankle to thigh-length, and are used for casual, formal, and business attire."),
            Shoe("18", "Geta", "6.0 - 15.0", "Macy's", "Geta are a form of traditional Japanese footwear resembling flip-flops. They are a kind of sandal with a flat wooden base elevated with up to three prongs, held on the foot with a fabric thong, which keeps the foot above the ground."),
            Shoe("20", "High-heeled shoes", "6.0 - 12.0", "Christian Louboutin", "High heels are a type of shoe in which the heel, compared with the toe, is significantly higher off the ground. They make the wearer appear taller, accentuate the muscle tone in their legs and make their legs appear visibly longer. There are many types of high heels, which come in different styles, colors and materials, and can be found all over the world. They have significant cultural and fashionable meanings attached to them, which have been largely shaped by historical contexts over the past 1,000 years."),
    )
}