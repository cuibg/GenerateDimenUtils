package cn.cuibg.generatedimenutils.util

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter

object GenerateDimenUtils {
    private val DIMEN_DP_PATH = "./app/src/main/res/values/dimens_dp.xml";
    private val DIMEN_SP_PATH = "./app/src/main/res/values/dimens_sp.xml"
    private val MAX_SIZE = 720

    @JvmStatic
    fun main(args: Array<String>) {

        writeDPFile()
        writeSPFile()
    }

    private fun writeDPFile() {
        val sw400 = StringBuilder()
        val xmlStart = """<?xml version="1.0" encoding="utf-8"?>
        <resources>"""

        sw400.append(xmlStart)
        //Add content
        for (i in 0..MAX_SIZE) {
            val start = "<dimen name=\"s_${i}dp\">"
            val end = "dp</dimen>"
            sw400.append(start).append(i).append(end).append("\n")
        }
        sw400.append("</resources>")
        val sw400file = DIMEN_DP_PATH
        writeFile(sw400file, sw400.toString())
    }

    private fun writeSPFile() {
        val sw400 = StringBuilder()
        val xmlStart = """<?xml version="1.0" encoding="utf-8"?>
        <resources>"""

        sw400.append(xmlStart)
        for (i in 0..MAX_SIZE) {
            val start = "<dimen name=\"s_${i}sp\">"
            val end = "sp</dimen>"
            sw400.append(start).append(i).append(end).append("\n")
        }
        sw400.append("</resources>")
        val sw400file = DIMEN_SP_PATH
        writeFile(sw400file, sw400.toString())
    }

    private fun writeFile(file: String?, text: String?) {
        var out: PrintWriter? = null
        try {
            out = PrintWriter(BufferedWriter(FileWriter(file)))
            out.println(text)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        out?.close()
    }
}