SUMMARY = "This out of tree module contains a number of blocks to help perform mapping between bits and symbols"
HOMEPAGE = "https://github.com/gr-vt/gr-mapper"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=eab9ee8e6de066f0b8e6fdc7460ba348"


DEPENDS = "gnuradio log4cpp cppunit swig-native python3-pybind11-native  python3-native python3-numpy-native"
RDEPENDS:${PN} = "gnuradio python3-click"

inherit setuptools3 cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/bkerler/gr-pager.git;branch=maint-3.10;protocol=https \
          "
SRCREV = "7df10f41709af2841058a7f42b3d641ee508d10e"

S = "${WORKDIR}/git"




EXTRA_OECMAKE = " \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DPYTHON3=1 \
    -DENABLE_DOXYGEN=OFF \
    "

INSANE_SKIP:${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
"
