package su.itschool.guru.service.irtechimport;

public class XMLSamples {
    static public final String INPUT_DATA_LESSONS = "<TimeTableExchange xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"TimeTableWeek.xsd\">\n" +
            "\t<LessonTimes>\n" +
            "\t\n" +
            "\t\t<LessonTime id=\"1\" starttime=\"8:00\" endtime=\"8:40\" sm=\"1\" number=\"1\" /> \n" +
            "\t\t<LessonTime id=\"2\" starttime=\"8:45\" endtime=\"9:25\" sm=\"1\" number=\"2\" /> \n" +
            "\t\t<LessonTime id=\"3\" starttime=\"9:35\" endtime=\"10:15\" sm=\"1\" number=\"3\" /> \n" +
            "\t\t<LessonTime id=\"4\" starttime=\"10:25\" endtime=\"11:05\" sm=\"1\" number=\"4\" /> \n" +
            "\t\t<LessonTime id=\"5\" starttime=\"11:25\" endtime=\"12:05\" sm=\"1\" number=\"5\" /> \n" +
            "\t\t<LessonTime id=\"6\" starttime=\"12:10\" endtime=\"12:50\" sm=\"1\" number=\"6\" /> \n" +
            "\t\t<LessonTime id=\"7\" starttime=\"13:20\" endtime=\"14:00\" sm=\"1\" number=\"7\" /> \n" +
            "\t\t<LessonTime id=\"8\" starttime=\"13:20\" endtime=\"14:00\" sm=\"2\" number=\"1\" /> \n" +
            "\t\t<LessonTime id=\"9\" starttime=\"14:10\" endtime=\"14:50\" sm=\"2\" number=\"2\" /> \n" +
            "\t\t<LessonTime id=\"10\" starttime=\"15:00\" endtime=\"15:40\" sm=\"2\" number=\"3\" /> \n" +
            "\t\t<LessonTime id=\"11\" starttime=\"15:50\" endtime=\"16:30\" sm=\"2\" number=\"4\" /> \n" +
            "\t\t<LessonTime id=\"12\" starttime=\"16:35\" endtime=\"17:15\" sm=\"2\" number=\"5\" /> \n" +
            "\t\t<LessonTime id=\"13\" starttime=\"17:20\" endtime=\"18:00\" sm=\"2\" number=\"6\" /> \n" +
            "\t</LessonTimes>\n" +
            "\t<teachers/>\n" +
            "\t<subjects/>\n" +
            "\t<Rooms/>\t\n" +
            "\t<Plan/>\n" +
            "</TimeTableExchange>";

    static public final String INPUT_DATA_TEACHERS = "<TimeTableExchange>\n" +
            "\t<LessonTimes/>\n" +
            "\t<teachers>\n" +
            "\t\t<teacher tid=\"1296030\" firstname=\"Александров\" middlename=\"Павел\" lastname=\"Владимирович\"/>\n" +
            "\t\t<teacher tid=\"3543910\" firstname=\"Павлов\" middlename=\"Павел\" lastname=\"Павлович\"/>\n" +
            "\t\t<teacher tid=\"1333034\" firstname=\"Петров\" middlename=\"Пётр\" lastname=\"Петрович\"/>\n" +
            "\t\t<teacher tid=\"1337081\" firstname=\"Семёнова\" middlename=\"Анна\" lastname=\"Ивановна\"/>\n" +
            "\t</teachers>\n" +
            "\t<subjects/>\n" +
            "\t<Rooms/>\t\n" +
            "\t<Plan/>\n" +
            "</TimeTableExchange>";

    static public final String INPUT_DATA_SUBJECTS = "<TimeTableExchange>\n" +
            "\t<LessonTimes/>\n" +
            "\t<teachers/>\n" +
            "\t<subjects>\n" +
            "\t\t<subject sid=\"92764\" name=\"математика\" abbr=\"матем.\">\n" +
            "\t\t\t<teacher tid=\"1251004\" />\n" +
            "\t\t\t<teacher tid=\"1251036\" /></subject>\n" +
            "\t\t<subject sid=\"85820\" name=\"физика\" abbr=\"физ.\">\n" +
            "\t\t\t<teacher tid=\"1251017\" />\n" +
            "\t\t\t<teacher tid=\"1251032\" />\n" +
            "\t\t\t<teacher tid=\"1267153\" />\n" +
            "\t\t\t<teacher tid=\"1273210\" /></subject>\n" +
            "\t\t<subject sid=\"294679\" name=\"русский язык\" abbr=\"рус.\">\n" +
            "\t\t\t<teacher tid=\"1251009\" />\n" +
            "\t\t\t<teacher tid=\"1273208\" />\n" +
            "\t\t\t<teacher tid=\"1279264\" /></subject>\n" +
            "\t\t<subject sid=\"92566\" name=\"литература\" abbr=\"лит-ра\">\n" +
            "\t\t\t<teacher tid=\"1251036\" /></subject>\n" +
            "\t</subjects>\t\n" +
            "\t<Rooms/>\t\n" +
            "\t<Plan/>\n" +
            "</TimeTableExchange>";

    static public final String INPUT_DATA_ROOMS = "<TimeTableExchange>\n" +
            "\t<LessonTimes/>\n" +
            "\t<teachers/>\n" +
            "\t<subjects/>\n" +
            "\t<Rooms>\n" +
            "\t\t<room id=\"53207\" name=\"2\" seats=\"30\" floor=\"1\"/>\n" +
            "\t\t<room id=\"53244\" name=\"22\" seats=\"32\" floor=\"1\"/>\n" +
            "\t\t<room id=\"53245\" name=\"23\" seats=\"32\" floor=\"1\"/>\n" +
            "\t\t<room id=\"53246\" name=\"24\" seats=\"32\" floor=\"1\"/>\n" +
            "\t\t<room id=\"53247\" name=\"25\" seats=\"32\" floor=\"1\"/>\n" +
            "\t\t<room id=\"53417\" name=\"28\" seats=\"32\" floor=\"1\"/>\n" +
            "\t\t<room id=\"53418\" name=\"29\" seats=\"30\" floor=\"1\"/>\n" +
            "\t</Rooms>\t\n" +
            "\t<Plan/>\n" +
            "</TimeTableExchange>";

    static public final String INPUT_DATA_PLAN = "<TimeTableExchange>\n" +
            "\t<LessonTimes/>\n" +
            "\t<teachers/>\n" +
            "\t<subjects/>\n" +
            "\t<Rooms/>\n" +
            "\t<Plan>\n" +
            "\t\t<class id=\"913934\" name=\"2А\" grade=\"2\" studcnt=\"26\" boys=\"15\" girls=\"11\"> \n" +
            "\t\t\t<csg id=\"4826768\" sid=\"85825\" name=\"Изобразительное искусство\" groupid=\"\" parentsubjectid=\"\" tid=\"1251015\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4826769\" sid=\"85827\" name=\"Музыка\" groupid=\"\" parentsubjectid=\"\" tid=\"1251043\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4929093\" sid=\"89298\" name=\"Иностранный язык/Иностранный язык (Английский язык)/англ.2 под\" groupid=\"81492\" parentsubjectid=\"60699\" tid=\"1251087\" hrsweek=\"2\" studcnt=\"13\"/>\n" +
            "\t\t\t<csg id=\"4826770\" sid=\"85831\" name=\"Математика\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"5\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4826774\" sid=\"86802\" name=\"Литературное чтение\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"4\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4826773\" sid=\"85841\" name=\"Русский язык\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"3\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4826775\" sid=\"86803\" name=\"Окружающий мир\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"2\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"5013102\" sid=\"88072\" name=\"Кружок &quot;Азбука добра&quot;\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"5013103\" sid=\"88086\" name=\"Кружок &quot;Инфознайка&quot;\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4826777\" sid=\"88078\" name=\"Кружок &quot;Мои проекты&quot;\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4826778\" sid=\"88079\" name=\"Кружок &quot;Наглядная геометрия&quot;\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"5013104\" sid=\"92556\" name=\"Кружок «Оригами»\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4928876\" sid=\"285087\" name=\"Родной язык (русский)\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4826771\" sid=\"85834\" name=\"Технология\" groupid=\"\" parentsubjectid=\"\" tid=\"1279262\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4826772\" sid=\"85837\" name=\"Физическая культура\" groupid=\"\" parentsubjectid=\"\" tid=\"1281337\" hrsweek=\"3\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866912\" sid=\"89298\" name=\"Иностранный язык/Иностранный язык (Английский язык)/англ.1 под\" groupid=\"81491\" parentsubjectid=\"60699\" tid=\"1322890\" hrsweek=\"2\" studcnt=\"13\"/>\n" +
            "\t\t</class>\t\t\n" +
            "\t\t<class id=\"913947\" name=\"6Б\" grade=\"6\" studcnt=\"25\" boys=\"8\" girls=\"17\"> \n" +
            "\t\t\t<csg id=\"4866982\" sid=\"85821\" name=\"География\" groupid=\"\" parentsubjectid=\"\" tid=\"1251012\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866988\" sid=\"85834\" name=\"Технология/д\" groupid=\"80636\" parentsubjectid=\"\" tid=\"1251015\" hrsweek=\"2\" studcnt=\"17\"/>\n" +
            "\t\t\t<csg id=\"4866983\" sid=\"85825\" name=\"Изобразительное искусство\" groupid=\"\" parentsubjectid=\"\" tid=\"1251015\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"5040545\" sid=\"293454\" name=\"Кружок &quot;Волшебный карандаш&quot;\" groupid=\"\" parentsubjectid=\"\" tid=\"1251015\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4955487\" sid=\"85834\" name=\"Технология/м\" groupid=\"80635\" parentsubjectid=\"\" tid=\"1251023\" hrsweek=\"2\" studcnt=\"8\"/>\n" +
            "\t\t\t<csg id=\"4866991\" sid=\"85841\" name=\"Русский язык\" groupid=\"\" parentsubjectid=\"\" tid=\"1251025\" hrsweek=\"7\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866990\" sid=\"85839\" name=\"Литература\" groupid=\"\" parentsubjectid=\"\" tid=\"1251025\" hrsweek=\"3\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866984\" sid=\"85827\" name=\"Музыка\" groupid=\"\" parentsubjectid=\"\" tid=\"1251043\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866985\" sid=\"85830\" name=\"Информатика/1 гр.\" groupid=\"80685\" parentsubjectid=\"\" tid=\"1251067\" hrsweek=\"1\" studcnt=\"17\"/>\n" +
            "\t\t\t<csg id=\"4963277\" sid=\"85830\" name=\"Информатика/2 гр.\" groupid=\"80637\" parentsubjectid=\"\" tid=\"1251067\" hrsweek=\"1\" studcnt=\"8\"/>\n" +
            "\t\t\t<csg id=\"4955495\" sid=\"89298\" name=\"Иностранный язык/Иностранный язык (Английский язык)/англ.2 под\" groupid=\"81492\" parentsubjectid=\"60699\" tid=\"1251087\" hrsweek=\"3\" studcnt=\"12\"/>\n" +
            "\t\t\t<csg id=\"4866981\" sid=\"85820\" name=\"Биология\" groupid=\"\" parentsubjectid=\"\" tid=\"1273210\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866986\" sid=\"85831\" name=\"Математика\" groupid=\"\" parentsubjectid=\"\" tid=\"1278096\" hrsweek=\"6\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866995\" sid=\"94312\" name=\"Кружок &quot;Развитие функциональной грамотности&quot;\" groupid=\"\" parentsubjectid=\"\" tid=\"1278096\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866987\" sid=\"85832\" name=\"История России. Всеобщая история\" groupid=\"\" parentsubjectid=\"\" tid=\"1279264\" hrsweek=\"2\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866992\" sid=\"86821\" name=\"Обществознание\" groupid=\"\" parentsubjectid=\"\" tid=\"1279264\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866994\" sid=\"89298\" name=\"Иностранный язык/Иностранный язык (Английский язык)/англ.1 под\" groupid=\"81491\" parentsubjectid=\"60699\" tid=\"1327411\" hrsweek=\"3\" studcnt=\"13\"/>\n" +
            "\t\t\t<csg id=\"4866989\" sid=\"85837\" name=\"Физическая культура\" groupid=\"\" parentsubjectid=\"\" tid=\"1333034\" hrsweek=\"3\" studcnt=\"0\"/>\n" +
            "\t\t\t<csg id=\"4866993\" sid=\"88090\" name=\"Секция &quot;Спортивные игры&quot;\" groupid=\"\" parentsubjectid=\"\" tid=\"1333034\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t</class>\t\n" +
            "\t\t<class id=\"927320\" name=\"10А\" grade=\"10\" studcnt=\"10\" boys=\"1\" girls=\"9\"> \n" +
            "\n" +
            "\t\t\t<csg id=\"5079239\" tid=\"1279263\" name=\"Индивидуальный проект/10АБ\" sid=\"282687\" studcnt=\"36\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4963529\" tid=\"1267155\" name=\"Иностранный язык/Иностранный язык (Английский язык)/У\" sid=\"89298\" studcnt=\"10\" hrsweek=\"6\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4962941\" tid=\"1279264\" name=\"История России. Всеобщая история/У\" sid=\"85832\" studcnt=\"10\" hrsweek=\"4\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4974049\" tid=\"1251025\" name=\"Литература/Б\" sid=\"85839\" studcnt=\"36\" hrsweek=\"3\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4963526\" tid=\"1289115\" name=\"Математика/Б\" sid=\"85831\" studcnt=\"10\" hrsweek=\"5\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"5072494\" tid=\"1251023\" name=\"Нравственные основы семейной жизни(ВНД)/10А\" sid=\"294680\" studcnt=\"10\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4963550\" tid=\"1273208\" name=\"Обществознание/Б\" sid=\"86821\" studcnt=\"12\" hrsweek=\"2\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4743553\" tid=\"1281337\" name=\"Основы безопасности жизнедеятельности/10\" sid=\"85836\" studcnt=\"36\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4963551\" tid=\"1279264\" name=\"Право/У\" sid=\"86823\" studcnt=\"10\" hrsweek=\"2\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4963527\" tid=\"1251025\" name=\"Родной язык (русский)/Б\" sid=\"285087\" studcnt=\"36\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4974038\" tid=\"1251025\" name=\"Русский язык/10АБ-У\" sid=\"85841\" studcnt=\"36\" hrsweek=\"3\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4743547\" tid=\"1251036\" name=\"Физика/Б\" sid=\"85823\" studcnt=\"10\" hrsweek=\"2\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4743554\" tid=\"1251037\" name=\"Физическая культура/10А\" sid=\"85837\" studcnt=\"10\" hrsweek=\"3\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"5069686\" tid=\"1267155\" name=\"Элективный курс иностр.язык/10АБ11А\" sid=\"86857\" studcnt=\"24\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"5069689\" tid=\"1279264\" name=\"Элективный курс история/10А11А\" sid=\"87211\" studcnt=\"15\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"5069687\" tid=\"1279264\" name=\"Элективный курс обществознание/10АБ11А\" sid=\"86858\" studcnt=\"19\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"5069664\" tid=\"1251025\" name=\"Элективный курс русский язык/10А\" sid=\"86856\" studcnt=\"10\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\t\t</class>\t\n" +
            "\n" +
            "\t\t<class id=\"913958\" name=\"11Б\" grade=\"11\" studcnt=\"24\" boys=\"19\" girls=\"5\"> \n" +
            "\n" +
            "\t\t\t<csg id=\"4993608\" tid=\"1251004\" name=\"Астрономия/11Б\" sid=\"92764\" studcnt=\"24\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4963561\" tid=\"1273210\" name=\"Биология/Б\" sid=\"85820\" studcnt=\"24\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"5079249\" tid=\"1279263\" name=\"Индивидуальный проект/11Б\" sid=\"282687\" studcnt=\"24\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4974047\" tid=\"1267155\" name=\"Иностранный язык/Иностранный язык (Английский язык)/11Б-Б\" sid=\"89298\" studcnt=\"21\" hrsweek=\"3\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4993557\" tid=\"1251067\" name=\"Информатика/11Б-1\" sid=\"85830\" studcnt=\"12\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4993560\" tid=\"1251067\" name=\"Информатика/11Б-2\" sid=\"85830\" studcnt=\"12\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"2\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4995502\" tid=\"1251025\" name=\"Литература/11Б\" sid=\"85839\" studcnt=\"24\" hrsweek=\"3\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"5072515\" tid=\"1251023\" name=\"Нравственные основы семейной жизни(ВНД)/11Б\" sid=\"294680\" studcnt=\"24\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4995526\" tid=\"1281337\" name=\"Основы безопасности жизнедеятельности/11Б\" sid=\"85836\" studcnt=\"24\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4993541\" tid=\"1251025\" name=\"Родной язык (русский)/11Б\" sid=\"285087\" studcnt=\"24\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4995463\" tid=\"1251025\" name=\"Русский язык/11Б-У\" sid=\"85841\" studcnt=\"24\" hrsweek=\"3\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4963564\" tid=\"1251004\" name=\"Физика/У\" sid=\"85823\" studcnt=\"24\" hrsweek=\"5\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"4995521\" tid=\"1251037\" name=\"Физическая культура/11Б\" sid=\"85837\" studcnt=\"24\" hrsweek=\"3\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"5068816\" tid=\"1279263\" name=\"Химия/11Б-Б\" sid=\"85824\" studcnt=\"24\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\n" +
            "\t\t\t<csg id=\"5101481\" tid=\"1251067\" name=\"Элективный курс информатика/11Б\" sid=\"87212\" studcnt=\"6\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> \n" +
            "\t\t</class>\t\t\n" +
            "\n" +
            "\n" +
            "\t</Plan>\t\n" +
            "</TimeTableExchange>";

}
