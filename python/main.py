import calc
import sys
def get_inputdata(csvfilename):
    # Import csv file
    with open(csvfilename) as f:
        head = f.readline()
        h = head.rstrip(",\n")
        header = h.split(",")
        lines = f.readlines()
        RowArray = []

        for line in lines:
            l = line.rstrip(",\n")
            row = l.split(",")
            RowArray.append(row)

        TurnTable = []
        for c in range(0, len(RowArray[0])):
            Column = []
            for r in range(0, len(RowArray)):
                Column.append(RowArray[r][c])
            TurnTable.append(Column)
        #print(TurnTable)
        return header, TurnTable


# Descriptive Statistics Code
def descriptivestatistics(inputfilename, outputfilename):

    header, InputData = get_inputdata(inputfilename)
    with open(outputfilename, 'w') as fout:
        fout.writelines("Column,Min,Max,Mean,Standard Deviation,Skewness,Kurtosis\n")

        nm = 0 #Column Number
        for cdata in InputData:
            #print(f"Column {nm + 1} Data: {cdata}")
            m = calc.mean(cdata)
            #print(f"Mean: {m}")
            mmax = calc.max(cdata)
            #print(f"Max: {mmax}")
            mmin = calc.min(cdata)
            #print(f"Min: {mmin}")
            sstanddev = calc.standdev(cdata)
            #print(f"Standard Deviation: {sstanddev}")
            skewnesses = calc.skewed(cdata)
            #print(f"Skewness: {skewnesses}")
            kurto = calc.kurtosis(cdata)
            #print(f"Kurtosis: {kurto}")

            # Min Max Mean StandardDev Skewness Kurtosis
            resultrow = f"{header[nm]},{mmin},{mmax},{m},{sstanddev},{skewnesses},{kurto}\n"
            fout.writelines(resultrow)
            nm = nm + 1

# Main Code


if __name__ == '__main__':
    #print(len(sys.argv))
    if len(sys.argv) > 2:
        inputfilename = sys.argv[1]
        outputfilename = sys.argv[2]
        print(f"Input File: {inputfilename}")
        print(f"Output File: {outputfilename}")
    else:
        print("Please provide input and output names as attributes. Your first file will be the input, and the second file the output")
        print("Example: python main.py inputfilename.csv outputfilename.csv")
        sys.exit()

    descriptivestatistics(inputfilename, outputfilename)




